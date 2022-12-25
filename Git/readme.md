- [Git](#git)
- [Local system to github](#local-system-to-github)
  - [New repo to existing online repo (empty)](#new-repo-to-existing-online-repo-empty)
  - [Locally created repo to existing online repo (empty)](#locally-created-repo-to-existing-online-repo-empty)

# Git

# Local system to github

## New repo to existing online repo (empty)

```sh
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin <link_of_existing_repo>
git push -u origin main
```

## Locally created repo to existing online repo (empty)

- The commands which need to be executed on terminal are as follows

```sh
git remote add origin <link_of_existing_repo>
git branch -M main
git push -u origin main
```
