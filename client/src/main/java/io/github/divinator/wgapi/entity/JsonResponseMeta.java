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

package io.github.divinator.wgapi.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Класс описывает сущность "мета данные" в ответе от Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public final class JsonResponseMeta {

    @SerializedName("count")
    private int count;

    /**
     * Метод возвращает количество сущностей в поле data
     *
     * @return Количество сущностей в поле data
     */
    public int getCount() {
        return count;
    }
}
