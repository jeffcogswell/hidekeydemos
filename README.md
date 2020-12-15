# Hiding Keys Java Demo

(I'll revise these notes; this is just the outline.)

This demo has multiple branches to demonstrate different ways of hiding and encrypting the keys.

In the GitHub code window, click on a branch to see each one.

## Demo App Version 1

Store keys in plaintext in application.properties file

## Demo App Version 2

Encrypt the keys but hardcode the encryption key inside the source code

## Demo App Version 3

Read the encryption key from an environment variable

This is considerably better, but there’s still a possibility for an attacker to access the environment variables.

## Demo App Version 4

The app is launched via an external system (e.g. ECS container system on AWS) and the environment variable lives in that external system.

The code is identical to version 3!

This is even better, but anyone with access to the ECS system via an AWS console login can see the key.

## Demo App Version 5

Move the key to a keystore in AWS. There are a few; we’ll use the Parameters Store. Note that the Parameters Store can encrypt the key itself using a master key so it can’t be easily read. Now the app reads the key from the parameter store.

However, for this to work, you need to configure authentication and authorization in AWS via IAM.

## Demo App Version 6

Quick note: Each computer running on AWS has two IP addresses, a public one and a private one. (The public one can be disabled, meaning the server can only be reached from other servers within the private network.)

Move app to a container

Use granular policies and permissions to grant the store’s access to the running app.


