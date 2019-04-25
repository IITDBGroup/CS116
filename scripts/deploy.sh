RSYNC=rsync
RSYNC_OPTS=-rv
SERVER=gauss.cs.iit.edu
USER=glavic
CURL=curl
SERVER_DIR=/home/glavic/public_html/cs116/
SERVER_FULL=${USER}@${SERVER}:${SERVER_DIR}
SCRIPTDIR=$(dirname "${BASH_SOURCE}")
DEPLOYDIR="${SCRIPTDIR}/../_site/"

echo "BUILD WITH RIGHT PREFIX"
bundle exec jekyll clean
bundle exec jekyll build
echo "DEPLOY ... ${DEPLOYDIR} TO ${SERVER_FULL}"
${RSYNC} ${RSYNC_OPTS} "${DEPLOYDIR}" "${SERVER_FULL}"
