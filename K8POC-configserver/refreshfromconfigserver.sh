#!/usr/bin/env bash
#kubectl get endpoints servicea-service -o jsonpath="{.subsets[*].addresses[*].ip}" | xargs -I % curl -X POST http://%/actuator/refresh  -d {} -H "Content-Type: application/json"
kubectl get endpoints servicea-service -o jsonpath="{.subsets[*].addresses[*].ip}"

#kubectl exec servicea-deployment-55bc8bf9fc-8qxht -- curl -X POST http://localhost:8010/actuator/refresh
# kubectl get pods --show-labels
#kubectl get pods --selector owner=michael

