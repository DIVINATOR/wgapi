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

package io.divinator.wgapi.entity.wgn.wgtv;

import com.google.api.client.util.Key;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущьность "Отфильтрованный по играм список техники, о которой есть видео." для метод-блока {@link io.divinator.wgapi.method.wgn.WgtvMethod}
 *
 * @author Sergey Divin
 */
public final class Vehicle {

    @Key("vehicles")
    private Map<String, List<Integer>> vehicles;

    /**
     * Метод возвращает карту идентификаторов техники по играм
     * <p>
     * Ключем является название игры
     * <p>
     * Значением является список идентификаторов техники
     *
     * @return Карту идентификаторов техники по играм
     */
    public Map<String, List<Integer>> getVehicles() {
        return vehicles;
    }
}
