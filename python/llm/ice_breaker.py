from dotenv import load_dotenv
from langchain_core.prompts import PromptTemplate
from langchain_openai import ChatOpenAI

from agents.linkedin_lookup_agent import linkedin_lookup_agent
from output_parsers import summary_parser, Summary
from third_parties.linkedin import scrape_linkedin_profile

def ice_break_with(name: str) -> Summary:
    linkedin_username = linkedin_lookup_agent(name=name)
    linkedin_data = scrape_linkedin_profile(linkedin_profile_url=linkedin_username)

    summary_template = """
            given the Linkedin information about a person from linkedin {information}
            I want you to create:
            1. A short summary
            2. two interesting facts about them
            
            \n{format_instructions}
            """

    summary_prompt_template = PromptTemplate(
        input_variables=["information"],
        template=summary_template,
        partial_variables={"format_instructions": summary_parser.get_format_instructions()}
    )

    llm = ChatOpenAI(temperature=0, model_name="gpt-4o-mini")

    # chain = summary_prompt_template | llm
    chain = summary_prompt_template | llm | summary_parser
    res = chain.invoke(input={"information": linkedin_data})

    print(res)

    return res


if __name__ == "__main__":
    load_dotenv()

    print("Ice Breaker Enter!")
    ice_break_with(name="Eden Marco")
