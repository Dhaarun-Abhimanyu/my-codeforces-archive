import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np # Adding NumPy just in case for completeness

# 1. Data Creation (Wide Format)
data = {
    'A': [60, 68, 72, 65, 75, 80, 74, 70, 69, 73],
    'B': [68, 60, 58, 64, 63, 65, 59, 61, 66, 60],
    'C': [82, 85, 79, 88, 90, 84, 81, 87, 83, 86]
}
df = pd.DataFrame(data)

print("Wide-format DataFrame:\n", df.head(), "\n")

# --- THE MISSING STEP: CONVERT WIDE TO LONG (TIDY) FORMAT ---
# We melt the DataFrame, making the column names (A, B, C) a new 'Class' column,
# and their values a new 'Score' column.
df_long = df.melt(var_name='Class', value_name='Score')

print("Long-format DataFrame:\n", df_long.head(15), "\n") # Uncomment to view df_long structure

# 2. Compute Summary Statistics for each batch
summary = df_long.groupby('Class')['Score'].agg(['mean', 'median', 'std', 'min', 'max'])

print("=== Batch-wise Summary Statistics ===")
print(summary, "\n")


# 3. Visualize Data

# --- Visualization 1: Boxplot (Distribution Comparison) ---
plt.figure(figsize=(7,5))
sns.boxplot(x='Class', y='Score', data=df_long, palette='pastel')
plt.title('Comparison of Scores Across Batches (Distribution)')
plt.ylabel('Score')
plt.xlabel('Class')
plt.show()


# --- Visualization 2: Bar Plot (Average Score Comparison) ---
# We group the long data and calculate the mean, then plot it directly
df_long.groupby('Class')['Score'].mean().plot(
    kind='bar',
    color=['salmon', 'skyblue', 'lightgreen']
)
plt.title('Average Score per Batch')
plt.ylabel('Mean Score')
plt.xlabel('Class')
plt.xticks(rotation=0) # Keeps x-labels horizontal
plt.show()