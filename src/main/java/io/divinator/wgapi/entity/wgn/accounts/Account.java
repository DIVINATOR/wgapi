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

package io.divinator.wgapi.entity.wgn.accounts;

import com.google.api.client.util.Key;
import io.divinator.wgapi.method.wgn.AccountsMethod;

import java.util.List;

/**
 * Класс описывает сущьность "Акаунт игрока" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class Account {

    @Key("games")
    List<String> games;

    @Key("created_at")
    private int createdAt;

    @Key("nickname")
    private String nickname;

    @Key("account_id")
    private int accountId;

    /**
     * Метод возвращает список игр, в которые играл игрок
     *
     * @return Список игр, в которые играл игрок
     */
    public List<String> getGames() {
        return games;
    }

    /**
     * Метод возвращает дату создания аккаунта игрока в формате timestamp
     *
     * @return Дата создания аккаунта игрока в формате timestamp
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Метод возвращает имя игрока
     *
     * @return Имя игрока
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Метод возвращает идентификатор игрока
     *
     * @return Идентификатор игрока
     */
    public int getAccountId() {
        return accountId;
    }
}