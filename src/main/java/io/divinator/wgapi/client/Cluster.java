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

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Перечисление кластеров и URL серверов Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public enum Cluster {

    /**
     * Кластер WorldOfTanks
     */
    WORLD_OF_TANKS("wot", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.RU, "api.worldoftanks.ru");
        servers.put(io.divinator.wgapi.client.Region.EU, "api.worldoftanks.eu");
        servers.put(io.divinator.wgapi.client.Region.NA, "api.worldoftanks.com");
        servers.put(io.divinator.wgapi.client.Region.ASIA, "api.worldoftanks.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfTanks Blitz
     */
    WORLD_OF_TANKS_BLITZ("wotb", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.RU, "api.wotblitz.ru");
        servers.put(io.divinator.wgapi.client.Region.EU, "api.wotblitz.eu");
        servers.put(io.divinator.wgapi.client.Region.NA, "api.wotblitz.com");
        servers.put(io.divinator.wgapi.client.Region.ASIA, "api.wotblitz.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfTanks Console
     */
    WORLD_OF_TANKS_CONSOLE("wotx", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.PS4, "api-ps4-console.worldoftanks.com");
        servers.put(io.divinator.wgapi.client.Region.XBOX, "api-xbox-console.worldoftanks.com");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfWarplanes
     */
    WORLD_OF_WARPLANES("wowp", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.RU, "api.worldofwarplanes.ru");
        servers.put(io.divinator.wgapi.client.Region.EU, "api.worldofwarplanes.eu");
        servers.put(io.divinator.wgapi.client.Region.NA, "api.worldofwarplanes.com");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfWarships
     */
    WORLD_OF_WARSHIPS("wows", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.RU, "api.worldofwarships.ru");
        servers.put(io.divinator.wgapi.client.Region.EU, "api.worldofwarships.eu");
        servers.put(io.divinator.wgapi.client.Region.NA, "api.worldofwarships.com");
        servers.put(io.divinator.wgapi.client.Region.ASIA, "api.worldofwarships.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер Wargaming.net
     */
    WARGAMING("wgn", ((Servers) () -> {
        Map<io.divinator.wgapi.client.Region, String> servers = new HashMap<>();
        servers.put(io.divinator.wgapi.client.Region.RU, "api.worldoftanks.ru");
        servers.put(io.divinator.wgapi.client.Region.EU, "api.worldoftanks.eu");
        servers.put(io.divinator.wgapi.client.Region.NA, "api.worldoftanks.com");
        servers.put(io.divinator.wgapi.client.Region.ASIA, "api.worldoftanks.asia");
        return servers;
    }).getServers());

    private String apiName;
    private Map<io.divinator.wgapi.client.Region, String> servers;

    /**
     * Конструктор перечисления кластера
     *
     * @param apiName Имя кластера
     * @param servers Сервера кластера
     */
    Cluster(String apiName, Map<io.divinator.wgapi.client.Region, String> servers) {
        this.apiName = apiName;
        this.servers = servers;
    }

    /**
     * Метод возвращает имя кластера
     *
     * @return Имя кластера
     */
    public String getApiName() {
        return this.apiName;
    }


    /**
     * <h3>Метод возвращает имя сервера по указанному региону.</h3>
     *
     * @param region регион для поиска имени сервера
     * @return Имя сервера по указанному региону
     * @throws NoSuchElementException В случае, если по указанному региону имя сервера не найдено.
     */
    public String getServerByRegion(io.divinator.wgapi.client.Region region) throws NoSuchElementException {

        if (this.servers.containsKey(region)) {
            return this.servers.get(region);
        }

        throw new NoSuchElementException("По указанному региону имя сервера не найдено");
    }

    /**
     * Интерфейс для создания карты серверов
     */
    private interface Servers {
        Map<Region, String> getServers();
    }
}
