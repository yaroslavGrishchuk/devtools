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