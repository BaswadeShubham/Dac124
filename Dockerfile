From ubuntu
RUN  apt-get update
RUN  apt-get install firefox
RUN firefox
CMD [ "firefox" ]
COPY . /hello
CMD  /hello/hello
