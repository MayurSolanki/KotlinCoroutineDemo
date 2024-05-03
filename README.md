# KotlinCoroutineDemo

Kotlin Coroutine 


# we can launch many coroutine


# Scopes in coroutine
   1 Coroutine Scope
   2 Global Scope

#. Dispatcher 
   1. IO.  ===> network I/O outside of the main thread.
   2. Default ====>  perform CPU-intensive work outside of the main thread. Example use cases include sorting a list and parsing JSON.
   3. Unconfined. ======>
   4. Main          =====>  Main thread UI android, to interact with UI only 

# Coroutine Builders
   1  launch.  => launch builder launches new coroutine without blocking current thread, Return instance of job which can be used as reference to coroutine
                           We use this builder that does not have any result as return value 
   
  2   Async. =>    As a result we want , parallel, create , launches new thread without blocking current thread
   3 Produce. =>. Produce. Stream of elements,  Block thread, 
   4 runBlocking => 


# Suspending Function
   1. With context
   2. WithTimeout
   3.  Delay
   4. Await
   5. Join

#  Structured Concurrency
     => Set of language features and rules for coroutine to avoid memory leak, and use coroutine productively

#  withContext
    You can switch thread but For that need suspend

# You can’t update view from background thread, View (Tv) can only be touch by those view who created it

# Suspending function does not block thread, Because it invoke from coroutine,  It block only Coroutine it self. 
     It block coroutine done its work then resume coroutine
   
