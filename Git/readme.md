- [Git](#git)
  - [First Step : Config](#first-step--config)
  - [Creating a local git project](#creating-a-local-git-project)
  - [Staging](#staging)
  - [Ignoring Files](#ignoring-files)
  - [Branches and Merging](#branches-and-merging)
  - [Merge Conflicts\*\*](#merge-conflicts)
  - [Stashing](#stashing)
  - [git clean](#git-clean)
  - [All Commands](#all-commands)
  - [NOTES](#notes)
- [Github](#github)
  - [Basic Terms](#basic-terms)
  - [Creating a new repo](#creating-a-new-repo)
  - [New repo to existing online repo (empty)](#new-repo-to-existing-online-repo-empty)
  - [Locally created repo to existing online repo (empty)](#locally-created-repo-to-existing-online-repo-empty)
  - [Pull Requests](#pull-requests)
  - [Organizing Projects](#organizing-projects)
  - [Syncing Git and GitHub](#syncing-git-and-github)
  - [Commands](#commands)

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

## Branches and Merging

- The point of branches is to create a separate location / chain (feature/fix branch) where a new feature is implemented OR an issue is fixed
- After appropriate fixes / feature development, we merge the branch to main branch
- After merging to main branch, we delete the feature/fix branch
- This whole process is called Git Flow
- In summary, Git Flow is
  - Create a Feature/Fix branch
  - Make changes / fixes on this branch
  - Merge this branch to master
  - Delete this branch

## Merge Conflicts\*\*

- Use VSCODE. It greatly assists in resolving merge conflicts
- Refer to this : https://youtu.be/nfOxUaA2trY

## Stashing

- Stashing is putting "temporary" work on a stack.
  - Like the interrupt process in CPU where CPU puts the current info about process in a stack and after servicing the interrupt request, it pops it back
  - The information on stash (stack) can be popped back

## git clean

- Source : https://www.atlassian.com/git/tutorials/undoing-changes/git-clean

> git clean command operates on untracked files. Untracked files are files that have been created within your repo's working directory but have not yet been added to the repository's tracking index using the git add command

## All Commands

| Command                     | Action                                                                |
| --------------------------- | --------------------------------------------------------------------- |
| git init                    | Create a git repo                                                     |
| git add `<FILENAME>`        | Stages the file `<FILENAME>`                                          |
| git add .                   | Stages all the files present in directory                             |
| git commit -m `<message>`   | Commits staged files with a message `<message>`                       |
| git log                     | Shows a list of commits and activites performed in the repo           |
| git log --oneline           | Brief list of commits and activites performed in the repo             |
| git log -`<num>`            | Shows the `<num>` most recent commits                                 |
| git status                  | Shows the status of files in the repo                                 |
| git restore -S `<FILENAME>` | Unstage a file                                                        |
| git restore `<FILENAME>`    | Restores / undoes any changes in the file `<FILENAME>`                |
| git restore .               | Restores / undoes all changes in project                              |
| git mv `<on>` `<nn>`        | Changes name of file from `<on>` to `<nn>` and stages it              |
| git rm `<file>`             | Deletes `<file>` from repo and stages it                              |
| git diff                    | Shows differences between files. Reference point is last commit       |
| git commit --amend          | Commits current changes to HEAD (previous commit)                     |
| git reset --hard `<hash>`   | Restores repo to the commit `<hash>`                                  |
| git branch                  | Shows available branches in repo. Current branch has `*`              |
| git checkout -b `<branch>`  | Creates and switches to the branch `<branch>`                         |
| git checkout `<branch>`     | Switches to the branch `<branch>`                                     |
| git merge `<branch>`        | Merges the **currently active** branch with `<branch>`                |
| git branch -D `<branch>`    | Deletes the branch `<branch>`                                         |
| git stash                   | Stashes (pushes on stack) current changes                             |
| git stash list              | Shows stashes (changes) present in stash (stack)                      |
| git stash pop               | Pops the topmost change from stash (stack)                            |
| git stash apply             | Applies changes from topmost of stash (stack) without popping         |
| git clean -n                | Dry run to detect untracked files that can be removed                 |
| git clean -nd               | Dry run to detect untracked files and directories that can be removed |
| git clean -df               | Removes untracked files and directories                               |

## NOTES

- Manual deletion (deleting files manually without using `git rm`) is equivalent to
  - Deleting the file
  - Having an "untracked" file (in `git status`) which needs to be staged
- Manual renaming of file (without using `git mv`) is equivalent to

  - Deleting the original file
  - Creating a new file with the same content as original file but having a new name
  - Having a "deleted" file (original) and an "untracked" file (new named file) in `git status`

  > These things can cause problems in stuff like `git diff` and thus, deletion / renaming of files should be done using git commands

- Instead of using `git diff` to see changes in terminal, use vscode extension [Gitlens](https://gitlens.amod.io/)

- A good tutorial for `git commit --amend` : https://youtu.be/Q5I8Y004DQ8

# Github

## Basic Terms

- Local Repo : The repo (git files) which we have locally on our system
- Remote Repo : The repo which is stored in a "remote" location (github, for example)
- Remote : A location where files can be uploaded to / fetched from
  - A remote consists of a name and a variable
  - A common name for a remote is **origin**
- An "upstream" link is a link from where you can pull and push changes.

## Creating a new repo

- To create a new repo, login to your github account
- Then navigate to the URL github.new
- You will get the options to create a new repo

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

```sh
git remote add origin <link_of_existing_repo>
git branch -M main
git push -u origin main
```

## Pull Requests

- It's like merging branches but on GitHub
- The pull requests can be reviewed by owner and others
- It also has a "comments" section where discussion can be done regarding the new changes
- After appropriate verification, the changes are merged to the main branch

## Organizing Projects

- To organize projects, GitHub provides us with these things
  - Contributors : People who have contributed in development of the project
  - Issues : A space where encountered issues in the project are reported and later rectified
  - Labels : Used for categorizing information
  - Milestones : A method to group issues together. Like taking care of all the issues in "Final Review" milestone.
  - Projects : Kanban boards on steroids
- Collaborators
  - Go to settings in GitHub repo
  - Then invite a collaborator
  - Used for private projects

## Syncing Git and GitHub

- Clone : Clones the online repo to our local machine
- Fetch : Obtains information from online repo and displays it with local repo
- Pull : Pulls changes from repo to local repo

## Commands

| Command                           | Action                                                          |
| --------------------------------- | --------------------------------------------------------------- |
| git remote add `<name>` `<URL>`   |                                                                 |
| git remote -v                     | Displays lists of remotes used by this repo                     |
| git rename `<old>` `<new>`        | Renames `<old>` remote name to `<new>` remote name              |
| git push `<remote>` `<branch>`    | Pushes `<branch>` to `<remote>`                                 |
| git push -u `<remote>` `<branch>` | Pushes `<branch>` to `<remote>` and sets `<remote>` as upstream |
| git push --all                    | Pushes all branches                                             |
| git clone `<repo>`                | Downloads `<repo>` from GitHub to local system                  |
| git fetch                         | Fetches information from remote repo and display it             |
