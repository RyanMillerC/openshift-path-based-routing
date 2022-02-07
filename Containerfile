# https://github.com/sclorg/nginx-container/blob/master/1.20/README.md

FROM registry.access.redhat.com/ubi8/nginx-120

ADD index.html .

CMD nginx -g "daemon off;"
