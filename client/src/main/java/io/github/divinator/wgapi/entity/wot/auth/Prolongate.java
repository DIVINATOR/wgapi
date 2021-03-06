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

package io.github.divinator.wgapi.entity.wot.auth;

import com.google.gson.annotations.SerializedName;

/**
 * Класс описывает сущность "Новый access_token" для метод-блока {@link io.github.divinator.wgapi.method.wot.AuthenticationMethod}
 *
 * @author Sergey Divin
 */
public final class Prolongate {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("expires_at")
    private int expiresAt;

    /**
     * Метод возвращает ключ доступа. Передаётся во все методы, требующие авторизацию.
     *
     * @return Ключ доступа. Передаётся во все методы, требующие авторизацию.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Метод возвращает идентификатор аккаунта игрока
     *
     * @return Идентификатор аккаунта игрока
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает срок действия access_token
     *
     * @return Срок действия access_token
     */
    public int getExpiresAt() {
        return expiresAt;
    }
}
