# Автотесты для сайта <a target="_blank" href="https://utorg.pro/">UTORGPRO</a>
![Intelij_IDEA](img/icons/utorg.png)

## Реализованы следующие проверки:
 - На главной странице есть кнопка Buy BTN
 - На главной странице после ввода невалидного номера карты возвращается ошибка
 - На главной странице заголовок "UTORG"
 - НА главной странице есть блок FAQ
 - При загрузке главной страницы в веб консоли нет ошибок
 - На главной странице кнопка SignIn перенаправляет на страницу авторизации
 - На главной странице кнопка SignUp перенаправляет на страницу авторизации
 - На странице авторизации при вводе невалидного емаил возвращается ошибка
 - На странице авторизации при вводе валидного емаил предлагается ввести Authorization code

 
## Используемые технологии и инструменты

![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Telegram](img/icons/Telegram.png)

# Джоба в Jenkins 
с параметрами:
<a target="_blank" href="jenkins.autotests.cloud">jenkins.autotests.cloud/job/</a>

## Запуск через Jenkins с параметрами:

![Jenkins](img/JenkinsRun.png)

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
![Telegram](img/Telegram.png)

---
## Анализ результатов
Ссылку на отчет Allure можно найти в 
* Сообщении Telegram
* В последней сборке Jenkins

Allure report (пример):
<a target="_blank" href="https://jenkins.autotests.cloud/job/">https://jenkins.autotests.cloud/job/</a>
![Allure](img/Allure_jenkins.png)
![Allure](img/Allure.png)

---
### Пример видео прохождения теста, прикрепляется к Allure отчету после каждого прохождения теста
