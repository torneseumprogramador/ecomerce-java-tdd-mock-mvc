git checkout .
git pull --force
sed -i '' -e "s/IMG_PARA_SUBSTITUIR/didox\/turma1_ibm_java_ecommerce_k8s:$TAG/" deployment-ecommerce-pipeline.yml
kubectl apply -f deployment-ecommerce-pipeline.yml