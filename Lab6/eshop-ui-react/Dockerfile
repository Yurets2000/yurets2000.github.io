# Name the node stage "builder"
FROM node:10 AS builder
# Set working directory
WORKDIR /app
# Copy all files from current directory to working dir in image
COPY . .
# Install node modules and build assets
RUN npm i && npm run build

# nginx state for serving content
FROM nginx:alpine
# Modify nginx.conf
COPY nginx.conf /etc/nginx/conf.d/nginx.conf
# Set working directory to nginx asset directory
WORKDIR /usr/share/nginx/html
# Remove default.conf
RUN rm /etc/nginx/conf.d/default.conf
# Remove default nginx static assets
RUN rm -rf ./*
# Copy static assets from builder stage
COPY --from=builder /app/build .
# Containers run nginx with global directives and daemon off
ENTRYPOINT ["nginx", "-g", "daemon off;"]