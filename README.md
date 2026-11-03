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