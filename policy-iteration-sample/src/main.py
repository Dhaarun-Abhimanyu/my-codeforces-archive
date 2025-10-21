from src.tabular_policy import TabularPolicy
from src.tabular_value_function import TabularValueFunction
from src.qtable import QTable
from src.mdp.gridworld import GridWorld
from src.policy import PolicyIteration

def main():
    # Initialize the MDP (GridWorld)
    grid_size = (4, 4)  # Example grid size
    mdp = GridWorld(grid_size)

    # Initialize the policy
    policy = TabularPolicy(mdp.get_states())

    # Create the PolicyIteration object
    policy_iteration = PolicyIteration(mdp, policy)

    # Run policy iteration
    iterations = policy_iteration.policy_iteration(max_iterations=100, theta=0.001)

    print(f"Policy iteration completed in {iterations} iterations.")

if __name__ == "__main__":
    main()