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
 * Класс описывает сущьность "Информация об аккаунте" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class AccountInformation {

    @Key("account_id")
    private int accountId;

    @Key("created_at")
    private int createdAt;

    @Key("nickname")
    private String nickname;

    @Key("games")
    List<String> games;

    @Key("private")
    private Private privat;

    /**
     * Класс описывает приватные данные игрока
     */
    public static class Private {

        @Key("freeXp")
        private int freeXp;

        @Key("gold")
        private int gold;

        @Key("premium_expires_at")
        private int premiumExpiresAt;

        /**
         * Метод возвращает количество свободного опыта
         *
         * @return Количество свободного опыта
         */
        public int getFreeXp() {
            return freeXp;
        }

        /**
         * Метод возвращает текущий баланс золота
         *
         * @return Текущий баланс золота
         */
        public int getGold() {
            return gold;
        }

        /**
         * Метод возвращает срок действия премиум аккаунта
         *
         * @return Срок действия премиум аккаунта
         */
        public int getPremiumExpiresAt() {
            return premiumExpiresAt;
        }
    }

    /**
     * Метод возвращает идентификатор игрока
     *
     * @return Идентификатор игрока
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает дату создания аккаунта игрока
     *
     * @return Дата создания аккаунта игрока
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
     * Метод возвращает список игр, в которые играл игрок
     *
     * @return Список игр, в которые играл игрок
     */
    public List<String> getGames() {
        return games;
    }

    /**
     * Метод возвращает приватные данные игрока
     *
     * @return Приватные данные игрока
     */
    public Private getPrivat() {
        return privat;
    }
}
