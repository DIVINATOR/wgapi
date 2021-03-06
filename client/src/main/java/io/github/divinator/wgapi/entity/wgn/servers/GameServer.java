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

package io.github.divinator.wgapi.entity.wgn.servers;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wgn.ServersMethod;

/**
 * Класс описывает сущность "Количество пользователей онлайн на игровом сервере" для метод-блока {@link ServersMethod}
 *
 * @author Sergey Divin
 */
public final class GameServer {

    @SerializedName("players_online")
    private int playersOnline;

    @SerializedName("server")
    private String server;

    /**
     * Метод возвращает количество игроков онлайн
     * @return Количество игроков онлайн
     */
    public int getPlayersOnline() {
        return playersOnline;
    }

    /**
     * Метод возвращает идентификатор сервера
     * @return Идентификатор сервера
     */
    public String getServer() {
        return server;
    }
}
