
from flask import Flask
from flask import request
from flask import jsonify

from werkzeug.serving import WSGIRequestHandler
import json
WSGIRequestHandler.protocol_version = "HTTP/1.1"

app = Flask(__name__)
global users
users = []
@app.route("/adduser", methods=['POST'])
def update_name():
    content = request.get_json(silent=True)
    
    userID = content["userID"]
    userPW = content["userPW"]

    global users
    exist = False
    for usr in users:
        if usr[0] == userID:
            exist = True

    if exist is False:
        users.append ([userID, userPW])
        return jsonify(success=True)
    else:
        return jsonify(success=False)
    
if __name__ == "__main__":
    app.run(host='localhost', port=8888)