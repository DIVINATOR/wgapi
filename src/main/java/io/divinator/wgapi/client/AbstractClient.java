/*
 * Copyright [2020] [Sergey Divin]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.divinator.wgapi.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Абстрактный класс, который описывает базовый функционал клиента для работы с Wargaming.net Public API
 *
 * @author Sergey Divin
 */
abstract class AbstractClient implements WgApi{

    private static final String DECLARED_FIELD = "client";
    private final Log log = LogFactory.getLog(getClass());

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API
     *
     * @return Объект строителя URL для Wargaming.net Public API
     */
    protected abstract WgApiUriBuilder getWgApiUriBuilder();

    /**
     * Метод возвращает объект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     *
     * @param classMethodBlock Класс метод-блока Wargaming.net Public API
     * @param client           Клиент для работы с Wargaming.net Public API
     * @param <T>              Тип класса метод-блока Wargaming.net Public API
     * @return объект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     * @throws WgApiException В случае, если произошла ошибка создания объекта, либо не найден публичный конструктор
     *                              по умолчанию, либо не удалось встроить клиент в метод-блок Wargaming.net Public API
     */
    protected  <T extends AbstractMethodBlock> T getMethodBlock(Class<T> classMethodBlock, AbstractHttpClient client) throws WgApiException {
        log.debug(String.format("Method block \"%s\" selected.", classMethodBlock.getName()));
        return (T) setClientInMethodBlock(instanceMethodBlock(classMethodBlock), client);
    }

    /**
     * Метод создает объект родительского класса AbstractMethodBlock
     *
     * @param classMethodBlock Класс метод-блока Wargaming.net Public API
     * @param <T>              Тип класса метод-блока Wargaming.net Public API
     * @return Объект родительского класса AbstractMethodBlock
     * @throws WgApiException В случае, если произошла ошибка создания обьекта, либо не найден публичный конструктор по умолчанию
     */
    private <T extends AbstractMethodBlock> T instanceMethodBlock(Class<T> classMethodBlock) throws WgApiException {
        for (Constructor<?> constructor : classMethodBlock.getConstructors()) {

            if (constructor.getParameterCount() == 0 && Modifier.isPublic(constructor.getModifiers())) {
                try {
                    return (T) constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new WgApiException(ErrorCode.CLIENT_REFLECTION_INSTANCE_METHOD_FAILED);
                } finally {
                    log.debug(String.format("Method block \"%s\" initialized.", classMethodBlock.getName()));
                }
            }
        }

        throw new WgApiException(ErrorCode.CLIENT_REFLECTION_INSTANCE_METHOD_NO_CONSTRUCTOR);
    }


    /**
     * Метод встраивает клиент в метод-блок Wargaming.net Public API
     *
     * @param methodBlock Метод-блок Wargaming.net Public API
     * @param client      Клиент для работы с Wargaming.net Public API
     * @return метод-блок с установленным клиентом Wargaming.net Public API
     * @throws WgApiException В случае, если не удалось встроить клиент в метод-блок Wargaming.net Public API
     */
    private AbstractMethodBlock setClientInMethodBlock(AbstractMethodBlock methodBlock, AbstractHttpClient client) throws WgApiException {

        Class<? extends AbstractMethodBlock> methodBlockClass = methodBlock.getClass();

        while (!methodBlockClass.isAssignableFrom(AbstractMethodBlock.class)) {
            methodBlockClass = (Class<? extends AbstractMethodBlock>) methodBlockClass.getSuperclass();
        }

        try {
            Field clientField = methodBlockClass.getDeclaredField(DECLARED_FIELD);
            clientField.setAccessible(true);
            clientField.set(methodBlock, client);
            return methodBlock;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new WgApiException(ErrorCode.CLIENT_REFLECTION_EMBED_FAILED);
        } finally {
            log.debug(String.format("Сlient is embedded in method block object \"%s\".", methodBlock.getClass().getName()));
        }
    }
}
