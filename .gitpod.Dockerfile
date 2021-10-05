FROM gitpod/workspace-full:latest

USER root

# Install custom tools, runtime, etc.

RUN ["apt-get", "update"]

RUN ["apt-get", "install", "-y", "zsh"]

USER gitpod

# clone
RUN git clone https://github.com/powerline/fonts.git --depth=1
# install
RUN cd fonts
# clean-up a bit
RUN cd ..
RUN rm -rf fonts

# set the zsh theme 
RUN git clone https://github.com/dbestevez/agitnoster-theme.git
RUN cd agitnoster-theme
RUN ./install.sh
ENV ZSH_THEME random

# Install Oh-My-Zsh

RUN wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh || true

  # start zsh

  CMD [ "zsh" ]

USER root
