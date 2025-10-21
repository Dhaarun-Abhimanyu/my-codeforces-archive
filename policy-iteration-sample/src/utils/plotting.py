def plot_value_function(value_function, title="Value Function"):
    import matplotlib.pyplot as plt
    import numpy as np

    states = list(value_function.keys())
    values = [value_function[state] for state in states]

    plt.figure(figsize=(10, 6))
    plt.bar(states, values, color='blue')
    plt.xlabel('States')
    plt.ylabel('Value')
    plt.title(title)
    plt.xticks(rotation=45)
    plt.grid()
    plt.show()

def plot_policy(policy, title="Policy"):
    import matplotlib.pyplot as plt

    states = list(policy.keys())
    actions = [policy[state] for state in states]

    plt.figure(figsize=(10, 6))
    plt.bar(states, actions, color='green')
    plt.xlabel('States')
    plt.ylabel('Action')
    plt.title(title)
    plt.xticks(rotation=45)
    plt.grid()
    plt.show()