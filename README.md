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
* [Apache HttpComponents](https://hc.apache.org/) версии 4.5.12
* [Gson](https://www.sites.google.com/site/gson/gson-user-guide) версии 2.8.6

### Документация проэкта
Документация проекта доступна [тут](https://divinator.github.io/docs/wgapi-client/index.html).

## Установка

Можно взять от сюда: [![Maven](https://img.shields.io/maven-central/v/io.github.divinator.wgapi/wgapi-client)](https://search.maven.org/artifact/io.github.divinator.wgapi/wgapi-client)

Добавить в файл <b>"pom.xml"</b> вашего проекта следующую зависимость:
```xml
<dependency>
  <groupId>io.github.divinator.wgapi</groupId>.                                     
  <artifactId>wgapi-client</artifactId>
  <version>2.0.0</version>
</dependency>
```

## Использование
Доступно несколько возможностей сконструировать обьект:
+ Указать только <b>"application_id"</b>
```
WgApi wgApi = WgApiFactory.getWgApi("application_id");
```
+  Указать <b>"регион"</b> и <b>"application_id"</b>
```
WgApi wgApi = WgApiFactory.getWgApi(Region.RU, "application_id");
```

> Указание собственного транспортного протокола возможно потребуется в случае, если работа клиента будет осуществляться через Proxy-сервер.

+ Далее необходимо инициализировать нужный "метод-блок", и у него вызвать нужный метод, с указанием параметров:
```
AccountsMethod methodBlock = wgApi.getMethodBlock(AccountsMethod.class);

JsonResponse<List<Account>> response = methodBlock.getListAccounts("DIVlNATOR");

List<Account> data = response.getData();
```

В параметры метода можно передать значение String или Parameter (последние могут быть в некоторых методах необязательными).

```
JsonResponse<List<Account>> response = methodBlock.getListAccounts("DIVlNATOR", new Parameter("language", "ru"));
```

+ Возвращаемое значение у методов <b>"метод-блока"</b> это JsonResponse и содержит данные типа:
  + List (<b>Entity</b>)
  + Map <String, (<b>Entity</b>)>
  + Map <String, List (<b>Entity</b>)>
    
> Entity - это сущности Wargaming.net Public API (см. [документацию](https://developers.wargaming.net/reference/)) со своими методами.

JsonResponse содержит ответ от Wargaming Api в виде объекта сконструированного из json-формата.
```
response.getData();     // данные, содержащие сущности
response.getError();    // данные об ошибке, если она есть
response.getMeta();     // метаданные запроса
response.isOk();        // true если запрос корректен, в противном случае false
```

Далее описан процесс получения нужных данных из <b>"Entity"</b>, на примере <b>"AccountInformation"</b>
```
  List<Account> data = response.getData();
  
  Account account = data.get(0);
          
  account.getAccountId();
  account.getNickname();
``` 

## Управление версиями
Мы используем [SemVer](http://semver.org/) для управления версиями. Для доступных версий, см. [tags](https://github.com/DIVINATOR/wgapi-client/tags). 

## Авторы
* **[Сергей "DIVINATOR"](https://divinator.github.io/)** - *Начальный этап работы* - <b><i>WgApiClient</i></b>

Также представлен список [участников](https://github.com/DIVINATOR/wgapi-client/graphs/contributors) в этом проекте.

## Лицензия

Этот проект лицензируется в соответствии с лицензией Apache — подробности см. в файле [LICENSE](LICENSE).
