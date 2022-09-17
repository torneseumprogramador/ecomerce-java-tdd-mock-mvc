git checkout .
git pull --force
sed -i '' -e "s/IMG_PARA_SUBSTITUIR/didox\/k8s_ecommerce:$TAG/" deployment-ecommerce-pipeline.yml
kubectl apply -f deployment-ecommerce-pipeline.yml