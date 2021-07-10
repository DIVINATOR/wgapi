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

package io.github.divinator.wgapi.entity.wgn.wargag;

import com.google.gson.annotations.SerializedName;

/**
 * Класс описывает сущность "Комментарий к контенту" для метод-блока {@link io.github.divinator.wgapi.method.wgn.WargagMethod}
 *
 * @author Sergey Divin
 */
public final class Comment {

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("comment")
    private String comment;

    @SerializedName("comment_id")
    private int commentId;

    @SerializedName("content_id")
    private int contentId;

    @SerializedName("created_at")
    private int createdAt;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("author")
    private InformationContent.Author author;

    /**
     * Метод возвращает идентификатор автора комментария
     * @return Идентификатор автора комментария
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает текст комментария
     * @return Текст комментария
     */
    public String getComment() {
        return comment;
    }

    /**
     * Метод возвращает идентификатор комментария
     * @return Идентификатор комментария
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * Метод возвращает идентификатор публикации
     * @return Идентификатор публикации
     */
    public int getContentId() {
        return contentId;
    }

    /**
     * Метод возвращает дата комментария
     * @return Дата комментария
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Метод возвращает имя игрока
     * @return Имя игрока
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Метод возвращает автора комментария {@link InformationContent.Author}
     * @return Автор комментария
     */
    public InformationContent.Author getAuthor() {
        return author;
    }
}
