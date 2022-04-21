rootProject.name = "demo"

include("domain")

include("application")

include("adapters:in:webapp")
include("adapters:in:consumer")

include("adapters:out:external")
include("adapters:out:persistence")