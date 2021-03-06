# Автотесты для сайта <a target="_blank" href="https://utorg.pro/">UTORGPRO</a>
![Intelij_IDEA](img/icons/utorg.png)

## Реализованы следующие проверки для главной страницы:
 1. На главной странице присутствует виджет с кнопкой Buy BTC
 2. На главной странице присутствует заголовок "UTORG"
 3. НА главной странице присутствует блок FAQ
 4. НА главной странице присутствует блок Guide Step-by-Step
 5. На главной странице после ввода невалидного номера карты возвращается ошибка
 6. На странице авторизации при вводе невалидного емаил возвращается ошибка
 7. На странице авторизации при вводе валидного емаил предлагается ввести Authorization code
 8. При загрузке главной страницы в веб консоли нет ошибок

 
## Используемые технологии и инструменты

![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Telegram](img/icons/Telegram.png)

# Джоба в Jenkins 
с параметрами:
<a target="_blank" href="https://jenkins.autotests.cloud/job/010-Azovtseva-hw13-utorgcom/">jenkins.autotests.cloud/job/010-Azovtseva-hw13-utorgcom//job/</a>

## Запуск через Jenkins с параметрами:

![Jenkins](img/jenkins.png)

## Локальный запуск через терминал:
```bash
gradlew clean test & gradlew allureReport
```

## Удаленный запуск через терминал с параметрами:
```bash
gradlew clean test -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1  & gradlew allureReport

```
___
## После прохождения тестов приходит оповещение в Telegram через бот 

#### После прохождения всех тестов, приходит отчет в канал в телеграме:
![Telegram](img/telegram.png)

---
## Анализ результатов
Ссылку на отчет Allure можно найти в
* Сообщении Telegram
* В последней сборке Jenkins

Allure report (пример):
<a target="_blank" href="https://jenkins.autotests.cloud/job/010-Azovtseva-hw13-utorgcom/4/allure">https://jenkins.autotests.cloud/job/010-Azovtseva-hw13-utorgcom/4/allure#</a>
![Allure](img/allure-report.png)

---
### Пример видео прохождения теста, прикрепляется к Allure отчету после каждого прохождения теста
![video](./img/allure-test-utorg.gif)
