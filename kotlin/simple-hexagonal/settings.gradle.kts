rootProject.name = "demo"

include("domain")

include("application")

include("adapters:in:webapp")
include("adapters:in:eventapp")

include("adapters:out:external")
include("adapters:out:persistence")