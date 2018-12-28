RSYNC=rsync
RSYNC_OPTS=-rv
SERVER=gauss.cs.iit.edu
USER=cs116
CURL=curl
SERVER_DIR=/home/cs116/public_html/
SERVER_FULL=${USER}@${SERVER}:${SERVER_DIR}
SCRIPTDIR=$(dirname "${BASH_SOURCE}")
DEPLOYDIR="${SCRIPTDIR}/../_site/"

echo "BUILD WITH RIGHT PREFIX"
jekyll clean
jekyll build
echo "DEPLOY ... ${DEPLOYDIR} TO ${SERVER_FULL}"
${RSYNC} ${RSYNC_OPTS} "${DEPLOYDIR}" "${SERVER_FULL}"
