#!/bin/bash

# Prompt for user input
read -p "Enter your full name: " NAME
read -p "Enter your email address: " EMAIL
read -p "Enter your Passphrase: " PASS

# Generate the GPG key
gpg --batch --generate-key <<EOF
Key-Type: RSA
Key-Length: 4096
Name-Real: $NAME
Name-Email: $EMAIL
Expire-Date: 0
Passphrase: $PASS
%commit
EOF

echo "GPG key generated successfully."