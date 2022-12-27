- [Git](#git)
  - [First Step : Config](#first-step--config)
  - [Creating a local git project](#creating-a-local-git-project)
  - [Staging](#staging)
  - [Ignoring Files](#ignoring-files)
  - [All Commands](#all-commands)
- [Local system to github](#local-system-to-github)
  - [New repo to existing online repo (empty)](#new-repo-to-existing-online-repo-empty)
  - [Locally created repo to existing online repo (empty)](#locally-created-repo-to-existing-online-repo-empty)

# Git

## First Step : Config

- After installing git, we need to add some information to the `git config` file
- The information which is to be provided is as follows

```
git config --global user.name "<github_username>"
git config --global user.email "<github_email>"
```

## Creating a local git project

- Navigate to the project directory and open the terminal (powershell / gitbash / linux terminals)
- On terminal, use the following command `git init`
- a `.git` folder is created. This file contains the data related to version control such as commits, branches etc.

## Staging

- A temporary area where a record of files which need to be committed are tracked
  - Initially, the files are in "working". This is the 0th step
  - 1st step is to stage a file.
  - 2nd step is to commit it
- To stage a file, we use the `git add <FILENAME>` command

> A commit is like a checkpoint : We can come back to a commit whenever we wish to

## Ignoring Files

- We do not need to track all the files in the project
  - Files which contains sensitive data should not be compromised
  - If they are not ignored, then the application will be compromised
- To specify a list of files which must be ignored, we create a file called `.gitignore`
  - Must be created at the root level of the project
  - Root level means the folder where `.git` folder exists
- **Ignored files are not uploaded on github**
- Files and folders can be ignored
  - To ignore a folder, add `<FOLDERNAME>/`
  - To ignore a file, add `<FILENAME>.<EXTENSION>`
  - To ignore all files of a specific extension, add `.<EXTENSION>`
- Global Ignore Files : [Source](https://www.git-scm.com/book/en/v2/Customizing-Git-Git-Configuration)

```
core.excludesfile

You can put patterns in your project’s .gitignore file to have Git not see them as untracked files or try to stage them when you run git add on them, as discussed in Ignoring Files.

But sometimes you want to ignore certain files for all repositories that you work with. If your computer is running macOS, you’re probably familiar with .DS_Store files. If your preferred editor is Emacs or Vim, you know about filenames that end with a ~ or .swp.

This setting lets you write a kind of global .gitignore file. The steps to do this is as follows
```

1. Create a file called .gitignore_global. Put everything which needs to be ignored inside it
2. Copy the absolute path of this file
3. Execute the command `git config --global core.excludesfile <path>`

> If gitignore is not working correctly, execute this command : `git rm -r --cached .`

## All Commands

| Command                           | Action                                                      |
| --------------------------------- | ----------------------------------------------------------- |
| git init                          | Create a git repo                                           |
| git add `<FILENAME>`              | Stages the file `<FILENAME>`                                |
| git add .                         | Stages all the files present in directory                   |
| git commit -m `<message>`         | Commits staged files with a message `<message>`             |
| git log                           | Shows a list of commits and activites performed in the repo |
| git status                        | Shows the status of files in the repo                       |
| git restore --staged `<FILENAME>` | Unstage a file                                              |
| git restore `<FILENAME>`          | Restores / undoes any changes in the file `<FILENAME>`      |
| git restore .                     | Restores / undoes all changes in project                    |

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
