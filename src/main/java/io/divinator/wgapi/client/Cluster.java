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
    WORLD_OF_TANKS("wot", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.RU, "api.worldoftanks.ru");
        servers.put(Region.EU, "api.worldoftanks.eu");
        servers.put(Region.NA, "api.worldoftanks.com");
        servers.put(Region.ASIA, "api.worldoftanks.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfTanks Blitz
     */
    WORLD_OF_TANKS_BLITZ("wotb", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.RU, "api.wotblitz.ru");
        servers.put(Region.EU, "api.wotblitz.eu");
        servers.put(Region.NA, "api.wotblitz.com");
        servers.put(Region.ASIA, "api.wotblitz.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfTanks Console
     */
    WORLD_OF_TANKS_CONSOLE("wotx", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.PS4, "api-ps4-console.worldoftanks.com");
        servers.put(Region.XBOX, "api-xbox-console.worldoftanks.com");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfWarplanes
     */
    WORLD_OF_WARPLANES("wowp", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.RU, "api.worldofwarplanes.ru");
        servers.put(Region.EU, "api.worldofwarplanes.eu");
        servers.put(Region.NA, "api.worldofwarplanes.com");
        return servers;
    }).getServers()),

    /**
     * Кластер WorldOfWarships
     */
    WORLD_OF_WARSHIPS("wows", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.RU, "api.worldofwarships.ru");
        servers.put(Region.EU, "api.worldofwarships.eu");
        servers.put(Region.NA, "api.worldofwarships.com");
        servers.put(Region.ASIA, "api.worldofwarships.asia");
        return servers;
    }).getServers()),

    /**
     * Кластер Wargaming
     */
    WARGAMING("wgn", ((Cluster.Servers) () -> {
        Map<Region, String> servers = new HashMap<>();
        servers.put(Region.RU, "api.worldoftanks.ru");
        servers.put(Region.EU, "api.worldoftanks.eu");
        servers.put(Region.NA, "api.worldoftanks.com");
        servers.put(Region.ASIA, "api.worldoftanks.asia");
        return servers;
    }).getServers());

    private String apiName;
    private Map<Region, String> servers;

    /**
     * Конструктор перечисления кластера
     *
     * @param apiName Имя кластера
     * @param servers Сервера кластера
     */
    Cluster(String apiName, Map<Region, String> servers) {
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


    public String getServerByRegion(Region region) throws NoSuchElementException {

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
