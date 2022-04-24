# Besthack'22 Финал

## Участники:
+ ### Ерхов Вадим Игоревич ([V4D1MECHE](https://github.com/V4D1MECHE)) (капитан)
+ ### Гунин Игорь Павлович ([notblank00](https://github.com/notblank00))
+ ### Касьяник Артемий Иванович ([Artemidividiy](https://github.com/Artemidividiy))
+ ### Ларшина Мария Андреевна ([larmari](https://github.com/larmari))

## Постановка задачи
Задача заключается в поиске и реализации методики преобразования данных об АЗС, и встриавании их в созданную нами базу данных.
Сложность задачи состоит в том, что мы не знаем, что получит наш микросервис, будь то запрос или файл. Также мы не можем быть уверены, что все поля входных данных будут соответствовать имеющимся в нашей таблице.

---
## Методика решения задачи.
Наше решение состоит в получии REST-запроса от пользователя микросервиса и его последующей обработке на [контроллере StationController](https://github.com/notblank00/besthack-22/blob/main/besthack22/src/main/java/ru/baza134/besthack22/controllers/StationController.java), мы получаем общую информацию о переданном файле или url-ссылке с запросом. 

После этого входной поток проходит через модуль [fetcher](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/fetchers). Если нам был передан url, то мы делаем из него, запрос и передаем ответ дальше [фабрике](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/factories), где определяются новые записи в базу данных.

## Этапы разработки решения:
+ ### Первое, что нужно было сделать: определить форматы данных, с которыми мы можем работать. Мы решили использовать: json, xml, csv.
+ ### Вторым этапом мы создали необходимые [модели](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/models),  [Сервисы](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/services) и [репозитории](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/repositories) для нашей базы данны.
+ ### Третьим этапом мы реализовали бизнес-логику:
  + #### [fetcher](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/fetchers). Он парсит входные данные в строки.
  + #### [конверсионная фабрика](https://github.com/notblank00/besthack-22/tree/main/besthack22/src/main/java/ru/baza134/besthack22/factories). Получает из fetcher строки и решает, как их преобразовывать.
+ ### Начали покрывать проект тестами.
+ ### Последним этапом мы подготоивили [контроллер StationController](https://github.com/notblank00/besthack-22/blob/main/besthack22/src/main/java/ru/baza134/besthack22/controllers/StationController.java). Он преставляет собой входную точку в программу.

--- 
### Проблемы, с которыми мы столкнулись в процессе работы и их решения
