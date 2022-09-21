# frontend build
FROM node:16.16.0 as builder
WORKDIR /var/jenkins_home/workspace/whatsub/vue
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

# run nginx server
FROM nginx:stable-alpine

COPY --from=builder /var/jenkins_home/workspace/whatsub/vue/dist /usr/share/nginx/html
COPY --from=builder /var/jenkins_home/workspace/whatsub/vue/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g","daemon off;"]