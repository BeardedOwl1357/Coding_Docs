- [Installation](#installation)
- [Usage](#usage)
  - [Basics](#basics)
  - [Commands](#commands)
- [Creating a Docker File](#creating-a-docker-file)
  - [Structure](#structure)
  - [Syntax](#syntax)
- [Tutorials](#tutorials)

**THE TUTORIAL IS INCOMPLETE AS CERTAIN AMOUNT OF DEVELOPMENT KNOWLEDGE IS NECESSARY TO ACTUALLY WORK WITH DOCKERFILE, DOCKER COMPOSE AND SUCH**

# Installation

- For windows, you will need to do the following
  - While installing Docker, enable WSL installation
  - [Make WSL2 as default](https://www.configserverfirewall.com/windows-10/wsl-version/)
  - Install a linux distro on windows (Go to Microsoft store, download ubuntu )

# Usage

## Basics

- Why use docker

  - When we need to use a software, instead of configuring your own system to execute the software, simply create a method by which the system configuration of the developer can be recreated
  - A list of instructions which create an environment using which an application can be executed on any OS (which supports docker)

- A docker file is a set of instructions to create a container
- A container is a stripped down virtual machine. This container executes instructions (provided by dockerfile).
- A docker file is converted to a docker image. This image is used to create a container

docker file -> docker image -> docker container

- The docker containers are executed and managed by docker server
  - We interact with docker server using docker client (commandline or GUI software)
  - The docker server is also called docker daemon. It is like a backend which manages everything

## Commands

| Command                          | Function                                                             |
| -------------------------------- | -------------------------------------------------------------------- |
| docker run `<image>`             | Runs an image. If not found locally, fetches from dockerhub, runs it |
| docker ps                        | Shows all running containers                                         |
| docker ps -a                     | Shows running and closed containers                                  |
| docker stop `<id>`               | Stops container of `<id>`. `<id>` obtained by `docker ps`            |
| docker kill `<id>`               | Forcefully Stops the container with the given `<id>`.                |
| docker logs `<id>`               | Shows the messages generated by a container                          |
| docker exec -i -t `<id>` `<cmd>` | Executes `<cmd>` inside container `<id>`                             |

**Learn how to build and commit to docker**

- Notes
  - If `docker stop` does not stop a process withing 10 seconds, it automatically executes the `docker kill` command
  - In the command `docker exec -i -t <id> <cmd>`
    - `-i` stands for "interactive". The full flag is `--interactive`
    - `-t` stands for "tty". Allocates a pseudo tty. [TTY Explanation](https://www.reddit.com/r/explainlikeimfive/comments/7gyqcv/comment/dqn8axi/?utm_source=share&utm_medium=web2x&context=3)

# Creating a Docker File

## Structure

- The general structure of a dockerfile is as follows

1. Choose a base image
2. Run commands for software
3. Specify the base (startup) command

- The name of the file is `Dockerfile`

## Syntax

| Keyword            | Function                                                            |
| ------------------ | ------------------------------------------------------------------- |
| #                  | Used for comments                                                   |
| FROM `<baseImage>` | Used to load a `<baseImage>`                                        |
| RUN `<cmd>`        | Used to execute the command `<cmd>`                                 |
| CMD `[<cmd>]`      | Makes `<cmd>` a startup command. Executed when `docker run` is used |

# Tutorials

-[ ] [(ENGLISH)Docker Tutorial by CodeWithMosh. Recent one](https://youtu.be/pTFZFxd4hOI) -[ ] [(HINDI) Docker Tutorial by CodeWithHarry](https://youtu.be/Gw2Jrid4SaQ) -[ ]
