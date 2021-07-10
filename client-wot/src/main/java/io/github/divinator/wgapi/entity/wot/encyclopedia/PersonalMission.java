package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Информацию о Личных боевых задачах" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class PersonalMission {

    @SerializedName("campaign_id")
    private int campaignId;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("operations")
    private Map<String, Operation> operations;

    /**
     * Метод возвращает идентификатор кампании.
     * @return Идентификатор кампании.
     */
    public int getCampaignId() {
        return campaignId;
    }

    /**
     * Метод возвращает описание кампании.
     * @return Описание кампании.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает название кампании.
     * @return Название кампании.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает операции кампании.
     * @return Операции кампании.
     */
    public Map<String, Operation> getOperations() {
        return operations;
    }

    /**
     * Сущность описывает операцию компании
     */
    public static class Operation {

        @SerializedName("description")
        private String description;

        @SerializedName("image")
        private String image;

        @SerializedName("missions_in_set")
        private int missionsInSet;

        @SerializedName("name")
        private String name;

        @SerializedName("next_id")
        private int nextId;

        @SerializedName("operation_id")
        private int operationId;

        @SerializedName("sets_count")
        private int setsCount;

        @SerializedName("sets_to_next")
        private int setsToNext;

        @SerializedName("missions")
        private Map<String, Mission> missions;

        @SerializedName("reward")
        private RewardOperation reward;

        /**
         * Метод возвращает описание операции.
         * @return Описание операции.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Метод возвращает ссылку на изображение операции.
         * @return Ссылка на изображение операции.
         */
        public String getImage() {
            return image;
        }

        /**
         * Метод возвращает количество задач в ветке.
         * @return Количество задач в ветке.
         */
        public int getMissionsInSet() {
            return missionsInSet;
        }

        /**
         * Метод возвращает название операции.
         * @return Название операции.
         */
        public String getName() {
            return name;
        }

        /**
         * Метод возвращает идентификатор следующей операции.
         * @return Идентификатор следующей операции.
         */
        public int getNextId() {
            return nextId;
        }

        /**
         * Метод возвращает идентификатор операции.
         * @return Идентификатор операции.
         */
        public int getOperationId() {
            return operationId;
        }

        /**
         * Метод возвращает количество веток задач операции.
         * @return Количество веток задач операции.
         */
        public int getSetsCount() {
            return setsCount;
        }

        /**
         * Метод возвращает количество веток до следующей операции.
         * @return Количество веток до следующей операции.
         */
        public int getSetsToNext() {
            return setsToNext;
        }

        /**
         * Метод возвращает задачи операции.
         * @return Задачи операции.
         */
        public Map<String, Mission> getMissions() {
            return missions;
        }

        /**
         * Метод возвращает награду за операцию.
         * @return Награда за операцию.
         */
        public RewardOperation getReward() {
            return reward;
        }

        /**
         * Сущность описывает миссию компании.
         */
        public static class Mission {

            @SerializedName("description")
            private String description;

            @SerializedName("hint")
            private String hint;

            @SerializedName("max_level")
            private int maxLevel;

            @SerializedName("min_level")
            private int minLevel;

            @SerializedName("mission_id")
            private int missionId;

            @SerializedName("name")
            private String name;

            @SerializedName("set_id")
            private int setId;

            @SerializedName("tags")
            private List<String> tags;

            @SerializedName("rewards")
            private Map<String, RewardMission> rewards;

            /**
             * Метод возвращает описание задачи.
             *
             * @return Описание задачи.
             */
            public String getDescription() {
                return description;
            }

            /**
             * Метод возвращает советы.
             *
             * @return Советы.
             */
            public String getHint() {
                return hint;
            }

            /**
             * Метод возвращает максимальный уровень техники.
             *
             * @return Максимальный уровень техники.
             */
            public int getMaxLevel() {
                return maxLevel;
            }

            /**
             * Метод возвращает минимальный уровень техники.
             *
             * @return Минимальный уровень техники.
             */
            public int getMinLevel() {
                return minLevel;
            }

            /**
             * Метод возвращает идентификатор задачи.
             *
             * @return Идентификатор задачи.
             */
            public int getMissionId() {
                return missionId;
            }

            /**
             * Метод возвращает название задачи.
             *
             * @return Название задачи.
             */
            public String getName() {
                return name;
            }

            /**
             * Метод возвращает идентификатор ветки задач.
             *
             * @return Идентификатор ветки задач.
             */
            public int getSetId() {
                return setId;
            }

            /**
             * Метод возвращает теги задачи.
             *
             * @return Теги задачи.
             */
            public List<String> getTags() {
                return tags;
            }

            /**
             * Метод возвращает награды, сгруппированые по условию задачи.
             *
             * @return Награды, сгруппированые по условию задачи.
             */
            public Map<String, RewardMission> getRewards() {
                return rewards;
            }

            /**
             * Сущность описывает награду миссии.
             */
            public static class RewardMission {

                @SerializedName("berths")
                private Object berths;

                @SerializedName("conditions")
                private String conditions;

                @SerializedName("credits")
                private Object credits;

                @SerializedName("free_xp")
                private Object freeXp;

                @SerializedName("items")
                private Map<String, Integer> items;

                @SerializedName("premium")
                private Object premium;

                @SerializedName("slots")
                private Object slots;

                @SerializedName("tokens")
                private Object tokens;

                /**
                 * Метод возвращает места в казарме.
                 *
                 * @return Места в казарме.
                 */
                public int getBerths() {
                    return (int) berths;
                }

                /**
                 * Метод возвращает условия задачи.
                 *
                 * @return Условия задачи.
                 */
                public String getConditions() {
                    return conditions;
                }

                /**
                 * Метод возвращает кредиты.
                 *
                 * @return Кредиты.
                 */
                public int getCredits() {
                    return (int) credits;
                }

                /**
                 * Метод возвращает свободный опыт.
                 *
                 * @return Свободный опыт.
                 */
                public int getFreeXp() {
                    return (int) freeXp;
                }

                /**
                 * Метод возвращает Список оборудования или расходников.
                 * <p>
                 * Формат: идентификатор - количество единиц
                 *
                 * @return Список оборудования или расходников.
                 */
                public Map<String, Integer> getItems() {
                    return items;
                }

                /**
                 * Метод возвращает дни премиум аккаунта.
                 *
                 * @return Дни премиум аккаунта.
                 */
                public int getPremium() {
                    return (int) premium;
                }

                /**
                 * Метод возвращает слоты.
                 *
                 * @return Слоты.
                 */
                public int getSlots() {
                    return (int) slots;
                }

                /**
                 * Метод возвращает токены.
                 *
                 * @return Токены.
                 */
                public int getTokens() {
                    return (int) tokens;
                }
            }
        }

        /**
         * Сущность описывает награду операции.
         */
        public static class RewardOperation {

            @SerializedName("slots")
            private Object slots;

            @SerializedName("tanks")
            private List<Integer> tanks;

            /**
             * Метод возвращает слоты.
             * @return Слоты.
             */
            public int getSlots() {
                return (int) slots;
            }

            /**
             * Метод возвращает список идентификаторов техники.
             * @return Список идентификаторы техники.
             */
            public List<Integer> getTanks() {
                return tanks;
            }
        }
    }
}
