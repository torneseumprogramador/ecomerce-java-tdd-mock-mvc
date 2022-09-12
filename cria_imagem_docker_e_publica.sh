./test.sh

echo "Digite a tag para publicação"
read TAG

git tag $TAG
git push --tags

docker build -t didox/ecommerce-treinamento-ibm:$TAG .
docker push didox/ecommerce-treinamento-ibm:$TAG