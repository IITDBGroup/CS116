SCRIPTDIR=$(dirname "${BASH_SOURCE}")
MAINDIR="${SCRIPTDIR}/.."
DEPLOYDIR="${MAINDIR}/_site"

pushd "${MAINDIR}"
echo "build without basedir"
jekyll build --baseurl ''
echo "run htmlproofer $(pwd)"
docker run --rm -v "$(pwd)/_site":/site 18fgsa/html-proofer /site --http-status-ignore 999 --check_favicon true --check_html true
result = $?
popd
exit $result
