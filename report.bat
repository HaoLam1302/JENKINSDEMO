set projectLocation=%~dp0
set reportPath=%projectLocation%allure-results

cd %projectLocation%src\test\resources\allure\2.13.8\bin
allure serve %reportPath%

PAUSE
