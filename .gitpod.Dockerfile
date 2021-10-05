FROM gitpod/workspace-full:latest

USER root

# Install custom tools, runtime, etc.

RUN ["apt-get", "update"]

RUN ["apt-get", "install", "-y", "zsh"]
RUN ["apt-get", "install", "fonts-powerline"]


USER gitpod


ENV ZSH_THEME random

# Install Oh-My-Zsh
RUN wget https://github.com/dbestevez/agitnoster-theme.git
RUN cd agitnoster-theme
RUN sudo sh ./install.sh
RUN wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh || true

  # start zsh

  CMD [ "zsh" ]

USER root
