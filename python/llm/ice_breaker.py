from dotenv import load_dotenv
import os
if __name__ == "__main__":
    load_dotenv()
    print("Hello LangChain!")
    print(os.getenv("COOL_API_KEY"))
