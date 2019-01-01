docker run -d -v "$(pwd)":/home/beakerx/cs116 -p 8888:8888 --name beakerx --rm iitdbgroup/beakerx:latest
sleep 10
docker logs beakerx 2>&1 | grep -o 'http://.*:8888/?token=.*' | head -n1 | sed -e 's/http:\/\/.*:8888/http:\/\/127.0.0.1:8888/g' | xargs open
