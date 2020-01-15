FROM python:3

MAINTAINER Ricardo Serrano <rxsh964@gmail.com>

# set a directory for the app
RUN mkdir /code
WORKDIR /code

# copy all the files to the container
COPY . .

# install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# tell the port number the container should expose
EXPOSE 8000

# run the command
CMD ["python", "./manage.py", "runserver", "0.0.0.0:8000"]