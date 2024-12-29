
sudo apt update && sudo apt upgrade -y
sudo apt install -y build-essential python3-pip git cmake

# Volte para o diretório principal do llama.cpp (se não estiver lá)
cd ~/Documentos/repositorios/llama.cpp

# Remova o build anterior
rm -rf build

# Crie um novo build com a opção para o servidor
cmake -B build -DLLAMA_BUILD_SERVER=ON
cmake --build build --config Release


curl -X POST http://localhost:11434/api/generate     -H "Content-Type: application/json"     -d '{
        "model": "llama3.1",
        "prompt": "Explique o que é inteligência artificial",
        "stream": false,
        "temperature": 0.7,
        "max_tokens": 500
    }'
