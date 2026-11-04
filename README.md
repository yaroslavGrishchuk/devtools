Правило веток: feature/DVT-X

Git локальный цикл

## Удалённый репозиторий: протокол доступа

- **Протокол:** SSH
- **Адрес origin:** `git@github.com:yaroslavGrishchuk/devtools.git`
- **Ключ:** `~/.ssh/github-ssh` (ed25519), добавлен в GitHub → Settings → SSH and GPG keys
- **Проверка доступа:**
  ```console
  $ ssh -T git@github.com
  Hi yaroslavGrishchuk! You've successfully authenticated, but GitHub does not provide shell access.

  $ git remote -v
  origin  git@github.com:yaroslavGrishchuk/devtools.git (fetch)
  origin  git@github.com:yaroslavGrishchuk/devtools.git (push)

markdown
## Сценарий ручной проверки DVT-6

**Запуск**
```bash
./gradlew run
```
Ожидаемый вывод: `Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков`

**Тесты**
```bash
./gradlew test
```
Ожидаемый вывод: `BUILD SUCCESSFUL`, все тесты зелёные.

**Debug**
- Breakpoint на `while (index < mentees.length)` в `ProgressTracker`.
- Debug `ProgressTracker.main()`, Step Over (F8) x3.
- Variables: `index` / `totalCompleted` / `totalTotal` растут как в таблице урока.
- Evaluate Expression: `totalCompleted + mentees[index].completedLessons()` = 25 (после 2-й итерации).

**При ошибках**
- Вывод неверный → проверь цикл через Debug.
- Тесты красные → открой Test Report, найди AssertionError.
- Breakpoint не срабатывает → убедись, что запущен Debug, не Run.

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией под нашу команду.
Автоматическая проверка: `./gradlew checkstyleMain`

### 1. Именование полей и методов: camelCase
До:    `private List<Student> student_list;`
После: `private List<Student> students;`

До:    `public void add_student(Student student)`
После: `public void addStudent(Student student)`

Почему: Java Convention требует camelCase для методов и полей. Это облегчает чтение кода и соответствует стандартам экосистемы.
Источник: Google Java Style Guide — Naming

### 2. Пробелы вокруг ключевых слов и операторов
До:    `if(condition)` или `for(Student s : list){`
После: `if (condition)` или `for (Student s : list) {`

До:    `int count=0;`
После: `int count = 0;`

Почему: Пробелы визуально отделяют ключевые слова от выражений, улучшая читаемость. Это критично при code review.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 100 символов
До:    `public List<Student> getStudentsByCityAndCityStartsWithLetterAWithLongMethodNameForCheckstyleDemonstration(String city)`
После:
```java
public List<Student> getStudentsByCityAndCityStartingWithA(
        String city) {