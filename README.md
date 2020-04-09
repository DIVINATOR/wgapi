# Java SDK для работы с Wargaming.net Public API
Данный проект является клиентом (далее по тексту <b><i>WgApiClient</i></b>) для удобного получения данных из набора общедоступных методов 
Wargaming.net Public API, которые предоставляют доступ к проектам Wargaming.net, включая игровой контент, 
статистику игроков, данные энциклопедии и многое другое.

## Приступая к работе
Перед началом работы с Wargaming.net Public API, ознакомьтесь с условиями 
[использования](https://developers.wargaming.net/documentation/rules/agreement/) 
и [документацией](https://developers.wargaming.net/reference/). Далее вам необходимо зарегистрировать приложение.

Для регистрации необходимо:
1. Войти в кабинет разработчика
2. Перейти в раздел ["Мои приложения"](https://developers.wargaming.net/applications/)
3. Нажать <b>"Добавить приложение"</b> (На экране появится форма для регистрации приложения).
4. Выбрать тип приложения. См. [Типы приложений](https://developers.wargaming.net/documentation/guide/principles/#application_types).
5. Ввести название приложения (Когда произведён вход в приложение, его название будет отображено на странице «Сеансы» 
в «Личном кабинете» пользователя).
6. Нажать <b>"Добавить приложение"</b> (На экране появится список добавленных приложений).
7. После успешной регистрации приложения вы получите <b>идентификатор приложения</b> (Далее по тесту <b>"application_id"</b>), 
который является идентификатором вашего приложения для обращения к API.

> Для получения контента WG Public API регистрация приложения является обязательной. См. [Использование application_id](https://developers.wargaming.net/documentation/guide/getting-started/#using_application_id). 

### Предварительные условия
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.8 или новее
* [Maven](https://maven.apache.org/download.cgi) 3.3.9 или новее

### Зависимости проэкта
<b><i>WgApiClient</i></b> использует:
* [Google HTTP Client Library for Java](https://github.com/googleapis/google-http-java-client) версии 1.34.2
* [GSON extensions to the Google HTTP Client Library](https://github.com/googleapis/google-http-java-client) версии 1.34.2

### Документация проэкта
Документация проекта доступна [тут](#).

## Установка
Вы можете найти последний релиз тут: [![Maven](https://img.shields.io/maven-central/v/com.vk.api/sdk.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.vk.api%22%20AND%20a%3A%22sdk%22)

Либо добавить в файл <b>"pom.xml"</b> вашего проекта следующую зависимость:
```
<dependency>
  <groupId>io.divinator.wgapi</groupId>
  <artifactId>wgapi-client</artifactId>
  <version>LATEST_VERSION</version>
</dependency>
```

## Использование
Доступно несколько возможностей сконструировать обьект:
+ Указать только <b>"application_id"</b>
```
WgApiClient client = new WgApiClient("application_id")
```
+  Указать <b>"регион"</b> и <b>"application_id"</b>
```
WgApiClient client = new WgApiClient(Region.RU, "application_id");
```
+  Указать <b>"транспортный протокол"</b>, <b>"регион"</b> и <b>"application_id"</b>
```
WgApiClient client = new WgApiClient(new NetHttpTransport(), Region.RU, "application_id");
```
> Указание собственного транспортного протокола возможно потребуется в случае, если работа клиента будет осуществляться через Proxy-сервер.

+ Далее необходимо инициализировать нужный "метод-блок", и у него вызвать нужный метод, с указанием параметров:
```
AccountsMethod methodBlock = client.getMethodBlock(AccountsMethod.class);

Map<String, AccountInformation> accountInfo = 
         methodBlock.getAccountInfo("DIVlNATOR", null, null, null);
```

Как вы успели уже заметить, в параметры метода можно передать значение <b>"null"</b>.
Переменные метода могут быть, как обязательные к заполнению, так и <b>"null"</b> (необязательные).
Чтобы избавиться от <b>"null"</b>, можно расширить нужный <b>"метод-блок"</b> и переопределить нужный метод.

+ Возвращаемое значение у методов <b>"метод-блока"</b> может быть нескольких типов:
  + List (<b>Entity</b>)
  + Map <String, (<b>Entity</b>)>
  + Map <String, List (<b>Entity</b>)>
  
> Entity - это сущности Wargaming.net Public API (см. [документацию](https://developers.wargaming.net/reference/)) со своими методами.

Далее описан процесс получения нужных данных из <b>"Entity"</b>, на примере <b>"AccountInformation"</b>
```
  AccountInformation accountInformation = accountInfo.get("3999999");
  accountInformation.getNickname();
  accountInformation.getAccountId();
``` 

## Внесение правок
Прочтите [CONTRIBUTING.md](CONTRIBUTING.md) чтобы получить подробную информацию о правилах и процессе подачи запросов на включение кода.

## Управление версиями
Мы используем [SemVer](http://semver.org/) для управления версиями. Для доступных версий, см. [tags](https://github.com/DIVINATOR/wgapi/tags). 

## Авторы
* **[Сергей "DIVINATOR"](https://divinator.github.io/)** - *Начальный этап работы* - <b><i>WgApiClient</i></b>

Также представлен список [участников](https://github.com/DIVINATOR/wgapi/graphs/contributors) в этом проекте.

## Лицензия

Этот проект лицензируется в соответствии с лицензией MIT — подробности см. в файле [LICENSE](LICENSE).
