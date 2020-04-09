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

/**
 * Перечисление поддерживаемых схем запроса к Wargaming.net Public API
 * <p>По умолчанию используется HTTPS</p>
 *
 * @author Sergey Divin
 */
public enum RequestScheme {
    HTTP,
    HTTPS;

    @Override
    public String toString() {
        return super.name().toLowerCase();
    }
}