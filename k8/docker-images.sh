REGISTRY_NAME=registry.cn-shenzhen.aliyuncs.com/k8s-opswolrd


IMAGES_NAME="kube-proxy-amd64:v1.10.4
kube-controller-manager-amd64:v1.10.4
kube-scheduler-amd64:v1.10.4
kube-apiserver-amd64:v1.10.4
etcd-amd64:3.1.12
k8s-dns-dnsmasq-nanny-amd64:1.14.8
k8s-dns-sidecar-amd64:1.14.8
k8s-dns-kube-dns-amd64:1.14.8
pause-amd64:3.1
heapster-amd64:v1.5.3
kubernetes-dashboard-amd64:v1.8.3
heapster-influxdb-amd64:v1.3.3"

for i in $IMAGES_NAME
do
  docker pull $REGISTRY_NAME/$i
  docker tag $REGISTRY_NAME/$i k8s.gcr.io/$i
done

docker pull $REGISTRY_NAME/flannel:v0.10.0-amd64
docker tag $REGISTRY_NAME/flannel:v0.10.0-amd64 quay.io/coreos/flannel:v0.10.0-amd64