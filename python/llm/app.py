from flask import Flask, render_template
from dotenv import load_dotenv

from ice_breaker import ice_break_with

load_dotenv()

app = Flask(__name__)

@app.route("/")
def index():
    res = ice_break_with(name="Eden Marco")
    # return jsonify(res)
    return render_template("index.html", data=res)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port="8080", debug=True)