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

import io.divinator.wgapi.entity.JsonResponseError;

/**
 * Класс описывает обьект исключения в работе {@link WgApiClient}
 *
 * @author Sergey Divin
 */
public class WgApiClientException extends Throwable {

    public WgApiClientException(ExceptionCode errorCode, Throwable throwable) {
        super(String.format("[%s][%s] \"%s\"", errorCode.getCode(), errorCode.name(), errorCode.getTitle()), throwable);
    }

    public WgApiClientException(ExceptionCode errorCode) {
        this(errorCode, null);
    }

    public WgApiClientException(JsonResponseError error) {
        this(((SetField) error1 -> {
            ExceptionCode exceptionCode = error1.getExceptionCode();
            exceptionCode.setField(error1.getField());
            return exceptionCode;
        }).setField(error));
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), this.getLocalizedMessage());
    }

    interface SetField {
        ExceptionCode setField(JsonResponseError error);
    }
}
